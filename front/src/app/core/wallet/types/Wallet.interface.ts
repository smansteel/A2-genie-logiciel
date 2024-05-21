import { Competence } from "./Competence.interface";

export interface Wallet {
  id: number;
  name: number;
  description: number;
  authorizedEditors: number[];
  competencies : Competence[]
}
