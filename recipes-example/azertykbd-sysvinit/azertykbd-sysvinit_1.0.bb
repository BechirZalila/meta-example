DESCRIPTION = "Setup a default (French) keyboard-layout for the console only"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

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

