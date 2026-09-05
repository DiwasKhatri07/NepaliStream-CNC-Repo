package com.cncverse;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SportzxProviderManager.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/SportzxProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/cncverse/SportzxStreamEntry;", "", "title", "", "link", "api", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getLink", "getApi", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "SportzxProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class SportzxStreamEntry {

    @Nullable
    private final String api;

    @Nullable
    private final String link;

    @Nullable
    private final String title;

    public static /* synthetic */ SportzxStreamEntry copy$default(SportzxStreamEntry sportzxStreamEntry, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sportzxStreamEntry.title;
        }
        if ((i & 2) != 0) {
            str2 = sportzxStreamEntry.link;
        }
        if ((i & 4) != 0) {
            str3 = sportzxStreamEntry.api;
        }
        return sportzxStreamEntry.copy(str, str2, str3);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLink() {
        return this.link;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getApi() {
        return this.api;
    }

    @NotNull
    public final SportzxStreamEntry copy(@Nullable String title, @Nullable String link, @Nullable String api) {
        return new SportzxStreamEntry(title, link, api);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SportzxStreamEntry)) {
            return false;
        }
        SportzxStreamEntry sportzxStreamEntry = (SportzxStreamEntry) other;
        return Intrinsics.areEqual(this.title, sportzxStreamEntry.title) && Intrinsics.areEqual(this.link, sportzxStreamEntry.link) && Intrinsics.areEqual(this.api, sportzxStreamEntry.api);
    }

    public int hashCode() {
        return ((((this.title == null ? 0 : this.title.hashCode()) * 31) + (this.link == null ? 0 : this.link.hashCode())) * 31) + (this.api != null ? this.api.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "SportzxStreamEntry(title=" + this.title + ", link=" + this.link + ", api=" + this.api + ')';
    }

    public SportzxStreamEntry(@Nullable String title, @Nullable String link, @Nullable String api) {
        this.title = title;
        this.link = link;
        this.api = api;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getLink() {
        return this.link;
    }

    @Nullable
    public final String getApi() {
        return this.api;
    }
}
