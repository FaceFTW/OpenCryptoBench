# OpenCryptoBench
A cryptography benchmark program written in Java

[![codebeat badge](https://codebeat.co/badges/5676f716-312c-4159-8012-67f94ead1ab1)](https://codebeat.co/projects/github-com-facestudios-opencryptobench)

[![Build Status](https://travis-ci.org/FaceStudios/OpenCryptoBench.svg?branch=master)](https://travis-ci.org/FaceStudios/OpenCryptoBench)

## Supported Algorithms
OpenCrpytoBench supports these algorithms:

*  Block Ciphers
  *  AES
  *  DES
  *  Blowfish
  *  RC2
  *  RC5
  *  3DES
  *  Serpent
  *  Twofish
  *  Threefish (Not Working right now)
  
*  Stream Ciphers
  *  ARCFOUR (RC4)
  *  Salsa20
  *  HC256
  *  ISSAC
  *  Grain128a
  
*  Public Key Ciphers
  *  RSA
  *  ElGamal

OpenCryptoBench will have support in the future for

*  Diffie-Hellman Key Exchange (In Progress)
*  A fix to the Threefish benchmark
*  X509 Certificate Validation Benchmarks
*  X509 Certificate Revocation Lists (CRL)
*  Post-Quantum Algorithms


## Legal Stuff
OpenCryptoBench is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

**This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.**

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.

OpenCrpytoBench uses the following libraries:

*  Google Guava (Apache 2.0)
*  Apache Commons Codec (Apache 2.0)
*  Bouncy Castle (MIT)

Also, a few shoutouts to some people whose code I borrowed:

* ntoskrnl (StackOverflow) - 	http://stackoverflow.com/a/22492582/7127790
* firatkucuk (Github) - https://github.com/firatkucuk/diffie-hellman-helloworld

All licenses of these libraries apply with the use of this program. No additional clauses are included with the use of this program
