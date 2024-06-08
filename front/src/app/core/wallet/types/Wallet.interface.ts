import { Competence } from "./Competence.interface";

export interface Wallet {
  id: number;
  name: string;
  description: string;
  authorizedEditorsID: number[];
  competencies: Competence[];
}
