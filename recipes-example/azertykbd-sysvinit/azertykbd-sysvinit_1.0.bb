DESCRIPTION = "Setup a default (French) keyboard-layout for the console only"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=b97a012949927931feb7793eee5ed924"

RDEPENDS_${PN} = "keymaps kbd-keymaps"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

inherit update-rc.d

SRC_URI = "file://azertykbd"

INITSCRIPT_NAME = "azertykbd"
INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_PARAMS = "start 99 5 2 ."

do_install () {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/azertykbd ${D}${sysconfdir}/init.d
}

