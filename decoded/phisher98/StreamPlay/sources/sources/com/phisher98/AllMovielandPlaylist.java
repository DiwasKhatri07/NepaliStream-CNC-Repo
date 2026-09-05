package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jq\u0010\u0014\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\bHÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/phisher98/AllMovielandPlaylist;", "", "file", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "key", "href", "host", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "getKey", "getHref", "getHost", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class AllMovielandPlaylist {

    @Nullable
    private final String file;

    @Nullable
    private final String host;

    @Nullable
    private final String href;

    @Nullable
    private final String key;

    public AllMovielandPlaylist() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ AllMovielandPlaylist copy$default(AllMovielandPlaylist allMovielandPlaylist, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = allMovielandPlaylist.file;
        }
        if ((i & 2) != 0) {
            str2 = allMovielandPlaylist.key;
        }
        if ((i & 4) != 0) {
            str3 = allMovielandPlaylist.href;
        }
        if ((i & 8) != 0) {
            str4 = allMovielandPlaylist.host;
        }
        return allMovielandPlaylist.copy(str, str2, str3, str4);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFile() {
        return this.file;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getHref() {
        return this.href;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getHost() {
        return this.host;
    }

    @NotNull
    public final AllMovielandPlaylist copy(@JsonProperty("file") @Nullable String file, @JsonProperty("key") @Nullable String key, @JsonProperty("href") @Nullable String href, @JsonProperty("host") @Nullable String host) {
        return new AllMovielandPlaylist(file, key, href, host);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AllMovielandPlaylist)) {
            return false;
        }
        AllMovielandPlaylist allMovielandPlaylist = (AllMovielandPlaylist) other;
        return Intrinsics.areEqual(this.file, allMovielandPlaylist.file) && Intrinsics.areEqual(this.key, allMovielandPlaylist.key) && Intrinsics.areEqual(this.href, allMovielandPlaylist.href) && Intrinsics.areEqual(this.host, allMovielandPlaylist.host);
    }

    public int hashCode() {
        return ((((((this.file == null ? 0 : this.file.hashCode()) * 31) + (this.key == null ? 0 : this.key.hashCode())) * 31) + (this.href == null ? 0 : this.href.hashCode())) * 31) + (this.host != null ? this.host.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AllMovielandPlaylist(file=" + this.file + ", key=" + this.key + ", href=" + this.href + ", host=" + this.host + ')';
    }

    public AllMovielandPlaylist(@JsonProperty("file") @Nullable String file, @JsonProperty("key") @Nullable String key, @JsonProperty("href") @Nullable String href, @JsonProperty("host") @Nullable String host) {
        this.file = file;
        this.key = key;
        this.href = href;
        this.host = host;
    }

    public /* synthetic */ AllMovielandPlaylist(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
    }

    @Nullable
    public final String getFile() {
        return this.file;
    }

    @Nullable
    public final String getKey() {
        return this.key;
    }

    @Nullable
    public final String getHref() {
        return this.href;
    }

    @Nullable
    public final String getHost() {
        return this.host;
    }
}
