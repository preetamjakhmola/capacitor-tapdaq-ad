import { registerPlugin } from '@capacitor/core';

import type { CapTapdaqAdPlugin } from './definitions';

const CapTapdaqAd = registerPlugin<CapTapdaqAdPlugin>('CapTapdaqAd', {
  web: () => import('./web').then(m => new m.CapTapdaqAdWeb()),
});

export * from './definitions';
export { CapTapdaqAd };
