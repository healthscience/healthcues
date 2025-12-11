module.exports = (chain) => {
  // Ensure plugin key exists to satisfy downstream .tap() calls, but do NOT use real TS checker
  if (!chain.plugins.has('ForkTsCheckerWebpackPlugin')) {
    class NoopPlugin { apply() {} }
    chain.plugin('ForkTsCheckerWebpackPlugin').use(NoopPlugin, [{}]);
  }
};
