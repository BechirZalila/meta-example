DESCRIPTION = "Setup a default (French) keyboard-layout for the console only"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

RDEPENDS_${PN} = "keymaps kbd-keymaps"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

inherit systemd

SRC_URI = "file://kbdlayout.service"

do_install () {
    install -d ${D}${base_libdir}/systemd/system
    install -m 0644 ${WORKDIR}/kbdlayout.service ${D}${base_libdir}/systemd/system/
}

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "kbdlayout.service"

FILES_${PN} += "${base_libdir}/systemd"
