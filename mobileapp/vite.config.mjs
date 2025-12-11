import { defineConfig, mergeConfig } from 'vite';
import { vueConfig } from '@nativescript/vite';

export default defineConfig(({ mode }) => {
  const base = vueConfig({ mode });
  return mergeConfig(base, {
    server: { host: true },
    esbuild: {
      target: 'es2015',
      supported: {
        'optional-chain': false,
        'nullish-coalescing': false,
        'object-rest-spread': false,
        'top-level-await': false
      }
    },
    build: { target: 'es2015' }
  });
});
