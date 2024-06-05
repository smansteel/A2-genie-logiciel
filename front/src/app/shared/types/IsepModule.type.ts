import { User } from "./User.type";
import { Wallet } from "../../core/wallet/types/Wallet.interface";

export interface IsepModule {
  id?: string;
  name?: string;
  description?: string;
  responsable?: User;
  wallets: Wallet[];
}
