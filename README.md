# Create Mock Soap Requests


<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
## Table Of Contents

- [Usage](#usage)
- [Dependencies](#dependencies)
- [External Depependencies](#external-depependencies)
- [Friendly Warning](#friendly-warning)
- [Updating The Source](#updating-the-source)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

## Usage
A command line tool to mock soap requests from a wsdl url

To use, clone this repo and make sure its bin directory is on your PATH by
adding the following to your \*rc file

```sh
# ~/.zshrc or ~/.bashrc file likely
PATH="<path to cloned directory>/bin:${PATH}"
```

source your rc file
```sh
. ~/.zshrc
```

and viola
```sh
cmsr '<a wsdl url>'
```

This will create a directory with the same name as the wsdl service.  If that
directory exists, it will first be deleted.  In that directory will be all the
mocked operation request xml payloads.

The service name is assumed to be the match found from the case insensitive regex
`.*/([^?]*)\\?wsdl$`

So for the wsdl url `http://int4p91pc.amfam.com/pc/ws/amfam/webservice/portal/endpoint/PCSubmissionDataService?wsdl`
the service name is `PCSubmissionDataService`.  If the wsdl you enter does not
follow this convention, then modify the source to fit your needs!  The code is
shorter and sweeter than shirley temple.

## Dependencies
This tool requires the java 8 runtime which you should [install via jenv](http://www.jenv.be/)

## External Depependencies
The directory 'external-deps' contains the cloned -> zipped soap-builder repository
written by username 'reficio'.  It's there in case his personal repository ever
goes down.

## Friendly Warning
I don't want to learn java enough to write a proper CLI interface (with common
behavior such as --help --version), so this is very bare bones.  Errors will
likely not be kind.  This tool is simply a helper alongside a more full-fledged
CLI enabling developers to hit sales SOAP endpoints with the minimal amount
of information.

TODO: Link that tool here once it's developed.

## Updating The Source
After updating the source, just run 'build-me.sh' to output the new monolithic
jar found in dist.
