import {
  CompanyInfoResponse,
  Response,
  SocialNetWorkResponse,
} from "@/appTypes/AxiosTypes";
import { app } from "@/main";

const url = "/info";

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
}

const company: CompanyAxios = {
  getInfo: async () => {
    return await getInfo();
  },
  getSocialNetwork: async () => {
    return await getSocialNetwork();
  },
};

export default company;
