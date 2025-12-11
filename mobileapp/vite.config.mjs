import { defineConfig, mergeConfig } from 'vite';
import { vueConfig } from '@nativescript/vite';

export default defineConfig(({ mode }) => {
  const base = vueConfig({ mode });
  return mergeConfig(base, {
    server: {
      host: true
    }
  });
});
