SUMMARY = "Example recipe for using inherit useradd"
DESCRIPTION = "This recipe serves as an example for using features from useradd.bbclass"
SECTION = "examples"
PR = "r1"
LICENSE = "MIT"

S = "${WORKDIR}"

inherit useradd

# You must set USERADD_PACKAGES when you inherit useradd. This
# lists which output packages will include the user/group
# creation code.
USERADD_PACKAGES = "${PN}"

# You must also set USERADD_PARAM and/or GROUPADD_PARAM when
# you inherit useradd.

# USERADD_PARAM specifies command line options to pass to the
# useradd command. Multiple users can be created by separating
# the commands with a semicolon. Here we'll create two users,
# user1 and user2:
USERADD_PARAM_${PN} = "-u 1000 -d /home/pi -r -s /bin/sh pi"

do_install () {
        install -d -m 755 ${D}/home/pi
	chown -R pi ${D}/home/pi
	chgrp -R pi ${D}/home/pi
}

FILES_${PN} = "/home/pi"

