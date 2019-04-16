package com.school.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;
import com.school.domain.Account;
import com.school.domain.Attendance;
import com.school.domain.Branch;
import com.school.domain.ClassTo;
import com.school.domain.User;
import com.school.domain.UserRole;
import com.school.repos.AttendanceRepository;
import com.school.repos.ClassRepository;
import com.school.repos.UserRepository;
import com.school.vo.AttendanceVo;
import com.school.vo.UserVo;

@Service
public class UserService {
	@Autowired
	private ApplicationConfiguration appplicationConfiguration;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ClassRepository classRepository;
	
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public File uploadFile(MultipartFile file, String path) throws IllegalStateException, IOException {
		String targetpath = path + file.getOriginalFilename();
		File targetFile = new File(targetpath);
		try {

			file.transferTo(targetFile);

		} catch (Exception ioexc) {
			ioexc.printStackTrace();
			throw ioexc;
		}
		return targetFile;
	}

	public List<UserVo> validateAndSaveUsereData(File file, ClassTo classTo) throws FileNotFoundException {
		List<UserVo> failedRecords = new ArrayList<>();
		Set<User> userList = new HashSet<>();
		CSVReader reader = null;
		Branch branch = classTo.getBranch();
		Account account = branch.getAccount();
		try {

			reader = new CSVReader(new FileReader(file));
			reader.forEach((String[] record) -> {

				UserVo userVo = new UserVo();
				userVo.readRecord(record);
				UserRole role = this.appplicationConfiguration.getRole(userVo.getRole());
				if (userVo.isFailedRecord()) {
					failedRecords.add(userVo);
				} else if (role == null) {
					failedRecords.add(userVo);
				} else {
					String userId = account.getAccountName() + "-" + branch.getBranchCode() + "-"
							+ classTo.getClassCode() + "-" + classTo.getSectionCode() + userVo.getUserCode();
					User user = userVo.getNewEntity();
					user.setUserId(userId);
					user.setUserRole(role);
					userList.add(user);
					user.setPassword(user.getPassword());

					try {
						userRepository.save(user);
						userList.add(user);
					} catch (Exception e) {
						e.printStackTrace();
						failedRecords.add(userVo);
					}

				}
			});
			classTo.setUsers(userList);
			classRepository.save(classTo);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return failedRecords;
	}

	public Set<AttendanceVo> validateAndSaveUserAttendanceeData(File uploadedFile, ClassTo classTo) {
		Set<AttendanceVo> errors = new HashSet<>();
		Set<User> classUsers = classTo.getUsers();
		CSVReader reader = null;
		try {
			if (CollectionUtils.isNotEmpty(classUsers)) {
				reader = new CSVReader(new FileReader(uploadedFile));
				List<String[]> records = reader.readAll();
				for (String[] record : records) {
					AttendanceVo vo = new AttendanceVo();
					vo.populateData(record);
					
					User user = classUsers.stream().filter((User us) -> {
						return us.getUserId().equals(vo.getUserId());
					}).findFirst().get();
					
					if (vo.isFailedRecord() || user == null) {
						errors.add(vo);
					}
					try
					{
						Attendance entity =vo.getEntity();
						entity.setUsers(user);
						entity.setClasses(classTo);
						attendanceRepository.save(entity);
						
						
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {

		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (Exception e) {

			}
		}
		return errors;
	}

}
