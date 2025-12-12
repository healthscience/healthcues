# healthCues mobile (NativeScript-Vue + Vite, JS)

Fresh baseline after reset.

- Vue 3 with NativeScript-Vue (JS only)
- Bundler: Vite
- App id: org.healthscience.healthcues_bb
- Android label: healthcue-bb
- Minimal UI: "healthCues from BentoBoxDS"
- No Tailwind, no websockets

## Scripts
- npm run dev:android — Vite HMR + Android debug
- npm run android — Android debug (bundles via Vite)

## Notes
- Use Node 20+ or 25 (as available locally)
- For first runs, if platform cache is stale: `npx ns clean` and reinstall
