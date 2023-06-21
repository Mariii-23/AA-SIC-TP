import { MaterialResponse, Response } from "@/appTypes/AxiosTypes";
import { app } from "@/main";
import { handleResponse } from "./axios";

const url = "/product";

const getAllMaterials = async (offset: number, numItems: number) => {
  try {
    const req = await app.config.globalProperties.$axios.get(
      `${url}/allMaterials`,
      {
        params: {
          offset,
          numItems,
        },
      }
    );

    return handleResponse(req, (data: MaterialResponse[]) => {
      return data;
    });
  } catch (error) {
    return {
      success: error.request.status,
      data: error.request.statusText,
    };
  }
};

const addMaterials = async (name: string, image: string) => {
  try {
    const req = await app.config.globalProperties.$axios.post(
      `${url}/material/add`,
      {
        name,
        image,
      }
    );

    return handleResponse(req, (data: MaterialResponse) => {
      return data;
    });
  } catch (error) {
    return {
      success: error.request.status,
      data: error.request.statusText,
    };
  }
};

const removeMaterial = async (id: string) => {
  try {
    const req = await app.config.globalProperties.$axios.delete(
      `${url}/material/remove/${id}`
    );

    return handleResponse(req, () => {
      return null;
    });
  } catch (error) {
    return {
      success: error.request.status,
      data: error.request.statusText,
    };
  }
};

const updateMaterial = async (id: string, name: string, image: string) => {
  try {
    const req = await app.config.globalProperties.$axios.post(
      `${url}/material/edit`,
      {
        id,
        name,
        image: image !== "" ? image : null,
      }
    );

    return handleResponse(req, (data: MaterialResponse) => {
      return data;
    });
  } catch (error) {
    return {
      success: error.request.status,
      data: error.request.statusText,
    };
  }
};

export interface CategoriesAxios {
  getAllMaterials: (
    offset: number,
    numItems: number
  ) => Promise<Response<MaterialResponse[]>>;
  addMaterial: (
    name: string,
    image: string
  ) => Promise<Response<MaterialResponse>>;
  updateMaterial: (
    id: string,
    name: string,
    image: string
  ) => Promise<Response<MaterialResponse>>;
  deleteMaterial: (id: string) => Promise<Response<void>>;
}

const materials: CategoriesAxios = {
  getAllMaterials: async (offset: number, numberItems: number) => {
    return await getAllMaterials(offset, numberItems);
  },
  addMaterial: async (name: string, image: string) => {
    return await addMaterials(name, image);
  },
  updateMaterial: async (id: string, name: string, image: string) => {
    return await updateMaterial(id, name, image);
  },
  deleteMaterial: async (id: string) => {
    return await removeMaterial(id);
  },
};

export default materials;
