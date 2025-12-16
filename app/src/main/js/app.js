'use strict'

Bare.on('uncaughtException', (err) => {
  print('Bare uncaughtException:', err && err.message)
})

print('Bare app.js booted')
