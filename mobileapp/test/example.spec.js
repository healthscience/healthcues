import { describe, it, expect } from 'vitest';

describe('basic sanity', () => {
  it('works', () => {
    expect('healthCues from BentoBoxDS').toContain('BentoBoxDS');
  });
});
