# lein-write-resources

A very simple Leiningen plugin to write resources on classpath to files.

## Usage

Put `[lein-write-resources "0.1.0"]` into the `:plugins` vector of your project.clj.

Add a `:write-resources` to your project.clj with pairs of resource/file pairs:

    :write-resources [["react/react.js" "target/classes/react/react.js"]
                      ["react/react.min.js" "target/classes/react/react.min.js"]]

Write resources by running the task:

    $ lein write-resources 

## License

Copyright © 2014 Justin Balthrop

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
