package com.phisher98;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: StreamPlayStremioAddon.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/phisher98/StreamPlayStremioAddonType;", "", "<init>", "(Ljava/lang/String;I)V", "SUBTITLE", "TORRENT", "HTTPS", "DEBRID", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public enum StreamPlayStremioAddonType {
    SUBTITLE,
    TORRENT,
    HTTPS,
    DEBRID;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    @NotNull
    public static EnumEntries<StreamPlayStremioAddonType> getEntries() {
        return $ENTRIES;
    }
}
