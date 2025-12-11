const webpack = require('@nativescript/webpack');

module.exports = (env) => {
  webpack.init(env);
  webpack.chainWebpack((config) => {
    try {
      // Guard against missing TS plugin expects inside nativescript-vue chain
      const applyVueChain = require('./nativescript-vue-chain');
      applyVueChain(config);
    } catch (e) {
      // safest: no-op
    }
  });
  return webpack.resolveConfig();
};
