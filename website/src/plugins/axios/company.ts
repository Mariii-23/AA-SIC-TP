import {
  CompanyInfoResponse,
  Response,
  SocialNetWorkResponse,
} from "@/appTypes/AxiosTypes";
import { CompanyInfo, SocialMedia } from "@/appTypes/Company";
import { app } from "@/main";

const url = "/info";

const updateInfo = async (company: CompanyInfo) => {
  try {
    await app.config.globalProperties.$axios.post(
      `${url}/companyInfo/edit`,
      company
    );

    return {
      success: true,
      data: company,
    };
  } catch (error) {
    return {
      success: false,
      data: "forbidden",
    };
  }
};

const updateNetworkLinks = async (socialNetworks: SocialMedia[]) => {
  try {
    await app.config.globalProperties.$axios.post(
      `${url}/socialNetworks/edit`,
      {
        socialNetworks,
      }
    );

    return {
      success: true,
      data: socialNetworks,
    };
  } catch (error) {
    return {
      success: false,
      data: "forbidden",
    };
  }
};

const getInfo = async () => {
  try {
    const req = await app.config.globalProperties.$axios.get(
      `${url}/all/companyInfo`
    );

    return {
      success: true,
      data: req.data,
    };
  } catch (error) {
    return {
      success: false,
      data: "forbidden",
    };
  }
};

const getSocialNetwork = async () => {
  try {
    const req = await app.config.globalProperties.$axios.get(
      `${url}/all/socialNetworks`
    );

    return {
      success: true,
      data: req.data,
    };
  } catch (error) {
    return {
      success: false,
      data: "forbidden",
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
