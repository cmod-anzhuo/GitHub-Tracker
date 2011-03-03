package com.menethil.githubtracker.base;

import android.content.Context;

import com.github.api.v2.services.CommitService;
import com.github.api.v2.services.FeedService;
import com.github.api.v2.services.GitHubServiceFactory;
import com.github.api.v2.services.OrganizationService;
import com.github.api.v2.services.RepositoryService;
import com.github.api.v2.services.UserService;

public class BaseContext {
	private static BaseContext baseContext;
	private ApiServiceFactory apiService;
	private Context context;

	private BaseContext() {

	}

	/**
	 * 获得唯一的实例
	 * 
	 * @return
	 */
	public synchronized static BaseContext getInstance() {
		if (baseContext == null) {
			baseContext = new BaseContext();
		}
		return baseContext;
	}

	/**
	 * 初始化运行环境
	 * 
	 * @param context
	 */
	public void inistContext(Context context) {
		this.context = context;
		this.apiService = new ApiServiceFactory();
	}

	public Context getContext() {
		return context;
	}

	public ApiServiceFactory getApiService() {
		return apiService;
	}

	/**
	 * API 服务封装
	 * 
	 * @author Menethil
	 * 
	 */
	private class ApiServiceFactory {
		private RepositoryService repositoryService;
		private CommitService commitService;
		private UserService userSerivce;
		private OrganizationService organService;
		private FeedService feedService;

		public ApiServiceFactory() {
			GitHubServiceFactory factory = GitHubServiceFactory.newInstance();
			this.repositoryService = factory.createRepositoryService();
			this.feedService = factory.createFeedService();
			this.organService = factory.createOrganizationService();
			this.userSerivce = factory.createUserService();
			this.commitService = factory.createCommitService();
		}

		@SuppressWarnings("unused")
		public RepositoryService getRepositoryService() {
			return repositoryService;
		}

		@SuppressWarnings("unused")
		public CommitService getCommitService() {
			return commitService;
		}

		@SuppressWarnings("unused")
		public UserService getUserSerivce() {
			return userSerivce;
		}

		@SuppressWarnings("unused")
		public OrganizationService getOrganService() {
			return organService;
		}

		@SuppressWarnings("unused")
		public FeedService getFeedService() {
			return feedService;
		}
	}
}
