import { WebPlugin } from '@capacitor/core';

import { CapTapdaqAdPlugin } from './definitions';
 
import { AdOptions, AdLoadInfo } from './shared';

export class CapTapdaqAdWeb extends WebPlugin implements CapTapdaqAdPlugin {

  constructor() {
    super({
      name: 'CapTapdaqAd',
      platforms: ['web'],
    });
  }

  
  async initialize(): Promise<void> {
     
  }
 
  async prepareRewardVideoAd(options: AdOptions): Promise<AdLoadInfo> { 
    return {
      adUnitId: options.adId,
    };
  }
 
}
