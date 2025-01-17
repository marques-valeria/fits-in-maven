package monitoredfits.rv;

import monitoredfits.fits.BackEnd;
import monitoredfits.fits.UserInfo;

public aspect Properties {

	before (): call(* BackEnd.initialise()) {
		Verification.fitsInitialisation();
	}

	before (): call(* UserInfo.openSession()) {
		Verification.fitsOpenSession();
	}

}
