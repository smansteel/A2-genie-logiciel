import { Roles } from "./Role.enum";

export interface User {
  id: number;
  isepId: string;
  firstName: string;
  name: string;
  role?: Roles;
}
