'use strict'
// Simple IPC echo protocol: read stdin (via BareKit IPC) and echo back with prefix
if (typeof BareKit !== 'undefined' && BareKit.on) {
  BareKit.on('ipc', (buf, reply) => {
    try {
      const str = buf.toString('utf8')
      reply(null, Buffer.from(`echo:${str}`, 'utf8'))
    } catch (err) {
      reply(err)
    }
  })
}


const RAM = require('random-access-memory')
const Hypercore = require('hypercore')
const Hyperbee = require('hyperbee')

Bare.on('uncaughtException', (err) => {
  print('Bare uncaughtException:', err && err.message)
})

;(async () => {
  print('Bare app.js booted')

  const core = new Hypercore(new RAM())
  await core.ready()

  const bee = new Hyperbee(core, { keyEncoding: 'utf-8', valueEncoding: 'json' })
  await bee.ready()

  // Simple protocol over stdin/stdout-style IPC when wired from Android later
  // For now, do a self-test put/get to verify bundle works
  await bee.put('greeting', { msg: 'hello from Hyperbee' })
  const node = await bee.get('greeting')
  print('Hyperbee get greeting =', JSON.stringify(node && node.value))
})().catch((err) => {
  print('Boot error:', err && err.message)
})
