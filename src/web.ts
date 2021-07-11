import { WebPlugin } from '@capacitor/core';

import type { CapTapdaqAdPlugin } from './definitions';

export class CapTapdaqAdWeb extends WebPlugin implements CapTapdaqAdPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
