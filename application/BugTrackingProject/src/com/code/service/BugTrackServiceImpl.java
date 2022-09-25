package com.code.service;

import java.util.List;

import com.code.bean.Bug;
import com.code.bean.Project;
import com.code.bean.User;
import com.code.dao.BugTrackDao;
import com.code.dao.BugTrackDaoImpl;
import com.code.exception.*;

public class BugTrackServiceImpl implements BugTrackService {

	private BugTrackDao bugTrackDao;

	public BugTrackServiceImpl() {

		bugTrackDao = new BugTrackDaoImpl();
	}

	@Override
	public List<Project> getAllProjects(int userid) {
		return bugTrackDao.getAllProjects(userid);
	}

	@Override
	public List<Project> getAllPMProjects(int managerid) {
		return bugTrackDao.getAllPMProjects(managerid);
	}

	@Override
	public int importUsers(List<User> userList) {
		return bugTrackDao.importUsers(userList);
	}

	@Override
	public List<Bug> getAllBugs(int projectid) {
		return bugTrackDao.getAllBugs(projectid);
	}

	@Override
	public List<User> getUsersByManager(Integer managerId) {
		return bugTrackDao.getUsersByManager(managerId);
	}

	@Override
	public boolean closeBug(int bugId) throws BugNotFoundException {
		return bugTrackDao.closeBug(bugId);
	}

	@Override
	public boolean assignDev(int bugId, int managerId) throws UserNotFoundException {
		return bugTrackDao.assignDev(bugId, managerId);
	}

	@Override
	public void addBug(Bug bug) throws ErrorInExecutionException {

		bugTrackDao.addNewBug(bug);
	}

	@Override
	public List<User> getAllEmployees(int mgrId) {
		return bugTrackDao.getAllEmployees(mgrId);
	}

	@Override
	public boolean addProject(Project project) throws ErrorInExecutionException {
		return bugTrackDao.addProject(project);
	}

	@Override
	public void updateNoOfProjects(int[] userIdchecked) {
		bugTrackDao.updateNoOfProjects(userIdchecked);
	}

	@Override
	public void addToTeam(String projectName, int[] userIdChecked, int managerid) throws ErrorInExecutionException {
		bugTrackDao.addUsersToProject(projectName, userIdChecked, managerid);

	}

	@Override
	public boolean addRemarks(int bugId, String remarks) throws ErrorInExecutionException {
		return bugTrackDao.addRemarks(bugId, remarks);

	}

	@Override
	public List<Bug> getAllDevBugs(int projectId, int userId) throws ErrorInExecutionException {
		return bugTrackDao.getAllDevBugs(projectId, userId);
	}

	@Override
	public Project getPMProject(int projectId) throws ErrorInExecutionException {
		return bugTrackDao.getPMProject(projectId);
	}

}
