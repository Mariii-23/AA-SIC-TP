import { defineStore } from "pinia";
import axios from "@/plugins/axios/axios";
import { Material } from "@/appTypes/Product";
import { MaterialResponse } from "@/appTypes/AxiosTypes";
import { baseUrl } from "@/main";

export const useMaterialStore = defineStore("materials", {
  state: () => ({
    materials: [] as Material[],
  }),
  actions: {
    async getAllMaterials() {
      const r = await axios.materials.getAllMaterials(0, 100000);
      console.log(r);
      if (r.success == 200) {
        this.materials = [];
        if (typeof r.data !== "string") {
          r.data.data.forEach((elem: MaterialResponse) => {
            this.materials.push({
              id: elem.id,
              name: elem.name,
              href: `${baseUrl}/product/all/materialImage?materialId=${elem.id}`,
            });
          });
        }
      }
    },
    async addMaterial(name: string, image: string) {
      const r = await axios.materials.addMaterial(name, image);
      if (r.success == 200) {
        if (typeof r.data === "string") {
          this.materials = [];
        } else {
          this.materials.push({
            id: r.data.id,
            name: r.data.name,
            href: `${baseUrl}/all/materialImage?materialId=${r.data.id}`,
          });
        }
      }
      return r.success;
    },
    async updateMaterial(id: string, name: string, image: string) {
      const r = await axios.materials.updateMaterial(id, name, image);
      if (r.success == 200) {
        if (typeof r.data !== "string") {
          const m = this.materials.findIndex((e) => {
            e.id == id;
          });

          this.materials[m] = {
            name: r.data.name,
            id: id,
            href: `${baseUrl}/product/all/materialImage?materialId=${id}`,
          };
        }
      }
      return r.success;
    },
    async removeMaterial(id: string) {
      const r = await axios.materials.deleteMaterial(id);
      if (r.success == 200) {
        if (typeof r.data !== "string") {
          this.materials = this.materials.filter((e) => e.id !== id);
        }
      }
      return r.success;
    },
  },
});
