package com.phisher98;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AnimePahePlugin.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/AnimePahe/classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001d\b\u0002\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/phisher98/ServerList;", "", "link", "Lkotlin/Pair;", "", "", "<init>", "(Ljava/lang/String;ILkotlin/Pair;)V", "getLink", "()Lkotlin/Pair;", "BEST", "ORG", "SI", "AnimePahe"}, k = 1, mv = {2, 4, 0}, xi = 48)
public enum ServerList {
    BEST(TuplesKt.to("https://animepahe.pw", true)),
    ORG(TuplesKt.to("https://animepahe.org", true)),
    SI(TuplesKt.to("https://animepahe.com", true));


    @NotNull
    private final Pair<String, Boolean> link;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    @NotNull
    public static EnumEntries<ServerList> getEntries() {
        return $ENTRIES;
    }

    ServerList(Pair link) {
        this.link = link;
    }

    @NotNull
    public final Pair<String, Boolean> getLink() {
        return this.link;
    }
}
