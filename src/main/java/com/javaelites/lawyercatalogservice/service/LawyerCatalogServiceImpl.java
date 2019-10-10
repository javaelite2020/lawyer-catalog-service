package com.javaelites.lawyercatalogservice.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.javaelites.lawyercatalogservice.dao.LawyerCatalogDao;
import com.javaelites.lawyercatalogservice.domain.dto.LawyerDetailsApiData;
import com.javaelites.lawyercatalogservice.domain.dto.LawyerListApiData;
import com.javaelites.lawyercatalogservice.model.Associations;
import com.javaelites.lawyercatalogservice.model.Awards;
import com.javaelites.lawyercatalogservice.model.Documents;
import com.javaelites.lawyercatalogservice.model.Education;
import com.javaelites.lawyercatalogservice.model.Endorsements;
import com.javaelites.lawyercatalogservice.model.LawyerDetails;
import com.javaelites.lawyercatalogservice.model.LawyerListApiModel;
import com.javaelites.lawyercatalogservice.model.LawyerResumeApiModel;
import com.javaelites.lawyercatalogservice.model.PracticeArea;
import com.javaelites.lawyercatalogservice.model.SpeakingEngagements;
import com.javaelites.lawyercatalogservice.responsehandler.LawyerCatalogResponseHandler;
import com.javaelites.lawyercatalogservice.util.ResponseApiData;
import com.javaelites.lawyercatalogservice.util.SearchApiData;

@Component
public class LawyerCatalogServiceImpl implements LawyerCatalogService {

	private static final Logger logger = LoggerFactory.getLogger(LawyerCatalogServiceImpl.class);
	
	@Autowired
	private LawyerCatalogDao lawyerCatalogDao;
	
	@Autowired
	private LawyerCatalogResponseHandler lawyerCatalogResponseHandler;
	
	@Override
	public ResponseApiData<LawyerListApiData> getAllLawyerList(String fields, PageRequest pageRequest, SearchApiData searchData) throws IOException {
		logger.debug("{} - Inside getAllLawyerList method", this.getClass());
		Page<LawyerListApiModel> lawyerDetails = lawyerCatalogDao.getAllLawyerList(pageRequest, searchData);
		return lawyerCatalogResponseHandler.handleLawyerCatalogResponse(lawyerDetails.getContent(), lawyerDetails.getTotalElements(), fields);
	}

	 
	public LawyerDetails getLawyerDetailsv2(String lawyerCode) {
		
		logger.debug("{} - Inside getLawyerDetails method", this.getClass());
		
		
		return new LawyerDetails();
	}

	@Override
	public ResponseApiData<LawyerDetailsApiData> getLawyerDetails(String lawyerCode) throws IOException {
	   LawyerDetails lawyerDetails = null;
	   if(lawyerCode != null) {
		 //1. get lawyer details
		 lawyerDetails = lawyerCatalogDao.getLawyerDetails(lawyerCode);
		   
		  //2. get lawyer location
		 lawyerDetails.setLocationList(lawyerCatalogDao.getLawyerLocationDetails(lawyerCode));
		   
		  //3. get lawyer consultation cost
		 lawyerDetails.setConsultationCostList(lawyerCatalogDao.getLawyerConsultationDetails(lawyerCode));
			   
		  //4. get other details
		  List<LawyerResumeApiModel> lawyerResumeList = lawyerCatalogDao.getLawyerResumeDetails(lawyerCode);
		  
		  setLawyerResumeDetails(lawyerDetails, lawyerResumeList);
		  
	   } else {
		   logger.error("Invalid request for getting lawyer details, lawyerCode is null ");
		   lawyerDetails= new LawyerDetails();
		   return  new ResponseApiData<LawyerDetailsApiData>();
	   }
	   List<LawyerDetails> lawyerDetailslist = new ArrayList<LawyerDetails>();
	   lawyerDetailslist.add(lawyerDetails);
	   return lawyerCatalogResponseHandler.handleLawyerDetailsResponse(lawyerDetailslist);
	}


	/**
	 * @param lawyerDetails
	 * @param lawyerResumeList
	 */
	private void setLawyerResumeDetails(LawyerDetails lawyerDetails, List<LawyerResumeApiModel> lawyerResumeList) {
		if (lawyerResumeList != null && lawyerDetails != null) {
			for (LawyerResumeApiModel profileModel: lawyerResumeList) {
				lawyerDetails.getAwardsList().add(extractAward(profileModel));
				lawyerDetails.getAssociationList().add(extractAssociation(profileModel));
				lawyerDetails.getDocumentList().add(extractDocument(profileModel));
				lawyerDetails.getEducationList().add(extractEducation(profileModel));
				lawyerDetails.getEndorsementList().add(extractEndorsement(profileModel));
				lawyerDetails.getPracticeAreaList().add(extractPracticeAreas(profileModel));
				lawyerDetails.getSpeakingEngagementList().add(extractSpeakingEngagement(profileModel));
			}
		}
	}

	private SpeakingEngagements extractSpeakingEngagement(LawyerResumeApiModel profileModel) {
		SpeakingEngagements speakingEngagements = null;
		if (profileModel != null && profileModel != null) {
//			speakingEngagements = new SpeakingEngagements ();
//			speakingEngagements.setConferenceDate(profileModel.getConferenceDate());
//			speakingEngagements.setConferenceName(profileModel.getConferenceName());
//			speakingEngagements.setTitle(profileModel.getSeTitle());
		}
		return speakingEngagements;
	}

	private PracticeArea extractPracticeAreas(LawyerResumeApiModel profileModel) {
		// TODO Auto-generated method stub
		return null;
	}


	private Endorsements extractEndorsement(LawyerResumeApiModel profileModel) {
		Endorsements endorsements = null;
		if (profileModel != null && profileModel.getEndorsementId() != null) {
			endorsements = new Endorsements ();
			endorsements.setDescription(profileModel.getDescription());
			endorsements.setEndorsementDate(profileModel.getEndorsementDate());
			endorsements.setRelationship(profileModel.getRelationship());
		}
		return endorsements;
	}


	private Education extractEducation(LawyerResumeApiModel profileModel) {
		Education education = null;
		if (profileModel != null && profileModel.getEducationId() != null) {
			education = new Education ();
			education.setDegree(profileModel.getDegree());
			education.setGraduatedDate(profileModel.getGraduatedYear());
			education.setSchoolName(profileModel.getSchoolName());
		}
		return education;
	}


	private Documents extractDocument(LawyerResumeApiModel profileModel) {
		// TODO Auto-generated method stub
		return null;
	}


	private Associations extractAssociation(LawyerResumeApiModel profileModel) {
		Associations associations = null;
		if (profileModel != null && profileModel != null) {
//			associations = new Associations ();
//			associations.setDuration(profileModel.getDuration());
//			associations.setName(profileModel.getName());
//			associations.setPositionName(profileModel.getName());
		}
		return associations;
	}


	private Awards extractAward(LawyerResumeApiModel profileModel) {
		Awards Awards = null;
		if (profileModel != null && profileModel != null) {
//			Awards = new Awards ();
//			Awards.setAwardDate(profileModel.get());
//			Awards.setAwardName(profileModel.get());
//			Awards.setGrantor(profileModel.get());
		}
		return Awards;
	}

}
