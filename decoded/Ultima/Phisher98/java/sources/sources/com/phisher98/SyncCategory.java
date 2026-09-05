package com.phisher98;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: UltimaSettingsSyncUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Ultima/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/phisher98/SyncCategory;", "", "key", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "EXTENSIONS", "SETTINGS", "BOOKMARKS", "RESUME_WATCHING", "SEARCH_HISTORY", "Ultima"}, k = 1, mv = {2, 4, 0}, xi = 48)
public enum SyncCategory {
    EXTENSIONS("extensions"),
    SETTINGS("settings"),
    BOOKMARKS("bookmarks"),
    RESUME_WATCHING("resume_watching"),
    SEARCH_HISTORY("search_history");


    @NotNull
    private final String key;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    @NotNull
    public static EnumEntries<SyncCategory> getEntries() {
        return $ENTRIES;
    }

    SyncCategory(String key) {
        this.key = key;
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }
}
