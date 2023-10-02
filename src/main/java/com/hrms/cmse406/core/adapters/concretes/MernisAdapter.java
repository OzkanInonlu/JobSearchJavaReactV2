package com.hrms.cmse406.core.adapters.concretes;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import com.hrms.cmse406.core.adapters.abstracts.MernisService;
import com.hrms.cmse406.entities.concretes.JobSeeker;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisAdapter implements MernisService{

	@Override
	public boolean checkPerson(JobSeeker jobSeeker) {
		
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();

		try {
			return kpsPublicSoapProxy.TCKimlikNoDogrula(Long.parseLong(jobSeeker.getIdentityNumber()),
					jobSeeker.getFirstName().toUpperCase(), jobSeeker.getLastName().toUpperCase(),
					jobSeeker.getBirthDate().getYear());
		} catch (NumberFormatException | RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

}
