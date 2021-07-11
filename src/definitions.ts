export interface CapTapdaqAdPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
