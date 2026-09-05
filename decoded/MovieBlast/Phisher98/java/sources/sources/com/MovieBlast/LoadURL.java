package com.MovieBlast;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MovieBlastParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/MovieBlast/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/MovieBlast/LoadURL;", "", "link", "", "server", "lang", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLink", "()Ljava/lang/String;", "getServer", "getLang", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "MovieBlast"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class LoadURL {

    @Nullable
    private final String lang;

    @Nullable
    private final String link;

    @Nullable
    private final String server;

    public LoadURL() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ LoadURL copy$default(LoadURL loadURL, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = loadURL.link;
        }
        if ((i & 2) != 0) {
            str2 = loadURL.server;
        }
        if ((i & 4) != 0) {
            str3 = loadURL.lang;
        }
        return loadURL.copy(str, str2, str3);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLink() {
        return this.link;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getServer() {
        return this.server;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLang() {
        return this.lang;
    }

    @NotNull
    public final LoadURL copy(@Nullable String link, @Nullable String server, @Nullable String lang) {
        return new LoadURL(link, server, lang);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoadURL)) {
            return false;
        }
        LoadURL loadURL = (LoadURL) other;
        return Intrinsics.areEqual(this.link, loadURL.link) && Intrinsics.areEqual(this.server, loadURL.server) && Intrinsics.areEqual(this.lang, loadURL.lang);
    }

    public int hashCode() {
        return ((((this.link == null ? 0 : this.link.hashCode()) * 31) + (this.server == null ? 0 : this.server.hashCode())) * 31) + (this.lang != null ? this.lang.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "LoadURL(link=" + this.link + ", server=" + this.server + ", lang=" + this.lang + ')';
    }

    public LoadURL(@Nullable String link, @Nullable String server, @Nullable String lang) {
        this.link = link;
        this.server = server;
        this.lang = lang;
    }

    public /* synthetic */ LoadURL(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    @Nullable
    public final String getLink() {
        return this.link;
    }

    @Nullable
    public final String getServer() {
        return this.server;
    }

    @Nullable
    public final String getLang() {
        return this.lang;
    }
}
