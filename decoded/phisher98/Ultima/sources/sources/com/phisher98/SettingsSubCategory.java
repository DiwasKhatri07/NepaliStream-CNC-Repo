package com.phisher98;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: UltimaSettingsSyncUtils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Ultima/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/phisher98/SettingsSubCategory;", "", "<init>", "(Ljava/lang/String;I)V", "PLAYER", "SUBTITLES", "THEME", "LAYOUT", "DOWNLOADS", "GENERAL", "Ultima"}, k = 1, mv = {2, 4, 0}, xi = 48)
public enum SettingsSubCategory {
    PLAYER,
    SUBTITLES,
    THEME,
    LAYOUT,
    DOWNLOADS,
    GENERAL;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    @NotNull
    public static EnumEntries<SettingsSubCategory> getEntries() {
        return $ENTRIES;
    }
}
