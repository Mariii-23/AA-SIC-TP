import {
  CompanyInfoResponse,
  Response,
  SocialNetWorkResponse,
} from "@/appTypes/AxiosTypes";
import { CompanyInfo, SocialMedia } from "@/appTypes/Company";
import { app } from "@/main";
import { handleResponse } from "./axios";

const url = "/info";

const updateInfo = async (company: CompanyInfo) => {
  try {
    const req = await app.config.globalProperties.$axios.post(
      `${url}/companyInfo/edit`,
      company
    );

    return handleResponse(req, () => {
      return company;
    });
  } catch (error) {
    return {
      success: error.request.status,
      data: error.request.statusText,
    };
  }
};

const updateNetworkLinks = async (socialNetworks: SocialMedia[]) => {
  try {
    const req = await app.config.globalProperties.$axios.post(
      `${url}/socialNetworks/edit`,
      {
        socialNetworks,
      }
    );
    return handleResponse(req, () => {
      return socialNetworks;
    });
  } catch (error) {
    return {
      success: error.request.status,
      data: error.request.statusText,
    };
  }
};

const getInfo = async () => {
  try {
    const req = await app.config.globalProperties.$axios.get(
      `${url}/all/companyInfo`
    );

    return handleResponse(req, (data) => {
      return data;
    });
  } catch (error) {
    return {
      success: error.request.status,
      data: error.request.statusText,
    };
  }
};

const getSocialNetwork = async () => {
  try {
    const req = await app.config.globalProperties.$axios.get(
      `${url}/all/socialNetworks`
    );

    return handleResponse(req, (data) => {
      return data;
    });
  } catch (error) {
    return {
      success: error.request.status,
      data: error.request.statusText,
    };
  }
};

export interface CompanyAxios {
  getInfo: () => Promise<Response<CompanyInfoResponse>>;
  getSocialNetwork: () => Promise<Response<SocialNetWorkResponse[]>>;
  getLogoLink: () => string;
  updateInfo: (company: CompanyInfo) => Promise<Response<CompanyInfo>>;
  updateNetworkLinks: (
    networkLinks: SocialMedia[]
  ) => Promise<Response<SocialMedia[]>>;
}

const company: CompanyAxios = {
  getInfo: async () => {
    return await getInfo();
  },
  getSocialNetwork: async () => {
    return await getSocialNetwork();
  },
  getLogoLink: () => {
    //FIXME:
    return "http://localhost:8080/info/all/companyImage";
  },
  updateInfo: async (company: CompanyInfo) => {
    return await updateInfo(company);
  },
  updateNetworkLinks: async (networkLinks: SocialMedia[]) => {
    return await updateNetworkLinks(networkLinks);
  },
};

export default company;
