package com.phisher98;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: QuickIPTV.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/QuickIPTV/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u0015\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jq\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010!\u001a\u00020\"HÖ\u0081\u0004J\n\u0010#\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006$"}, d2 = {"Lcom/phisher98/PlaylistItem;", "", "title", "", "attributes", "", "headers", "url", "userAgent", "key", "keyid", "<init>", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getAttributes", "()Ljava/util/Map;", "getHeaders", "getUrl", "getUserAgent", "getKey", "getKeyid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "QuickIPTV"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class PlaylistItem {

    @NotNull
    private final Map<String, String> attributes;

    @NotNull
    private final Map<String, String> headers;

    @Nullable
    private final String key;

    @Nullable
    private final String keyid;

    @Nullable
    private final String title;

    @Nullable
    private final String url;

    @Nullable
    private final String userAgent;

    public PlaylistItem() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlaylistItem copy$default(PlaylistItem playlistItem, String str, Map map, Map map2, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = playlistItem.title;
        }
        if ((i & 2) != 0) {
            map = playlistItem.attributes;
        }
        if ((i & 4) != 0) {
            map2 = playlistItem.headers;
        }
        if ((i & 8) != 0) {
            str2 = playlistItem.url;
        }
        if ((i & 16) != 0) {
            str3 = playlistItem.userAgent;
        }
        if ((i & 32) != 0) {
            str4 = playlistItem.key;
        }
        if ((i & 64) != 0) {
            str5 = playlistItem.keyid;
        }
        String str6 = str4;
        String str7 = str5;
        String str8 = str3;
        Map map3 = map2;
        return playlistItem.copy(str, map, map3, str2, str8, str6, str7);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final Map<String, String> component2() {
        return this.attributes;
    }

    @NotNull
    public final Map<String, String> component3() {
        return this.headers;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getUserAgent() {
        return this.userAgent;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getKeyid() {
        return this.keyid;
    }

    @NotNull
    public final PlaylistItem copy(@Nullable String title, @NotNull Map<String, String> attributes, @NotNull Map<String, String> headers, @Nullable String url, @Nullable String userAgent, @Nullable String key, @Nullable String keyid) {
        return new PlaylistItem(title, attributes, headers, url, userAgent, key, keyid);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlaylistItem)) {
            return false;
        }
        PlaylistItem playlistItem = (PlaylistItem) other;
        return Intrinsics.areEqual(this.title, playlistItem.title) && Intrinsics.areEqual(this.attributes, playlistItem.attributes) && Intrinsics.areEqual(this.headers, playlistItem.headers) && Intrinsics.areEqual(this.url, playlistItem.url) && Intrinsics.areEqual(this.userAgent, playlistItem.userAgent) && Intrinsics.areEqual(this.key, playlistItem.key) && Intrinsics.areEqual(this.keyid, playlistItem.keyid);
    }

    public int hashCode() {
        return ((((((((((((this.title == null ? 0 : this.title.hashCode()) * 31) + this.attributes.hashCode()) * 31) + this.headers.hashCode()) * 31) + (this.url == null ? 0 : this.url.hashCode())) * 31) + (this.userAgent == null ? 0 : this.userAgent.hashCode())) * 31) + (this.key == null ? 0 : this.key.hashCode())) * 31) + (this.keyid != null ? this.keyid.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "PlaylistItem(title=" + this.title + ", attributes=" + this.attributes + ", headers=" + this.headers + ", url=" + this.url + ", userAgent=" + this.userAgent + ", key=" + this.key + ", keyid=" + this.keyid + ')';
    }

    public PlaylistItem(@Nullable String title, @NotNull Map<String, String> map, @NotNull Map<String, String> map2, @Nullable String url, @Nullable String userAgent, @Nullable String key, @Nullable String keyid) {
        this.title = title;
        this.attributes = map;
        this.headers = map2;
        this.url = url;
        this.userAgent = userAgent;
        this.key = key;
        this.keyid = keyid;
    }

    public /* synthetic */ PlaylistItem(String str, Map map, Map map2, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? MapsKt.emptyMap() : map, (i & 4) != 0 ? MapsKt.emptyMap() : map2, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5);
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final Map<String, String> getAttributes() {
        return this.attributes;
    }

    @NotNull
    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final String getUserAgent() {
        return this.userAgent;
    }

    @Nullable
    public final String getKey() {
        return this.key;
    }

    @Nullable
    public final String getKeyid() {
        return this.keyid;
    }
}
