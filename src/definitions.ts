
import { IRewardDefinitions } from "./reward";

type CapTapdaqAdDefinitions = IRewardDefinitions;

export interface CapTapdaqAdPlugin extends CapTapdaqAdDefinitions {
  initialize(options: CapTapdaqAdInitializationOptions): Promise<void>;
}


export interface CapTapdaqAdInitializationOptions {
  /**
   * Use or not requestTrackingAuthorization in iOS(>14)
   * 
   */
  requestTrackingAuthorization?: boolean;

  /* 
   */
  testingDevices?: string[];

  /**
   * @default false 
   */
  initializeForTesting?: boolean;
}