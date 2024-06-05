import { User } from "./User.type";

export interface Module {
  id?: number,
  name?: string,
  description?: string,
  responsable?: User,
}
