package com.cncverse;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PlayZTVProviderManager.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/PlayZTVProvider/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JJ\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/cncverse/PlayZStreamUrl;", "", "name", "", "link", "scheme", "", "api", "tokenApi", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getLink", "getScheme", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getApi", "getTokenApi", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/cncverse/PlayZStreamUrl;", "equals", "", "other", "hashCode", "toString", "PlayZTVProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class PlayZStreamUrl {

    @Nullable
    private final String api;

    @Nullable
    private final String link;

    @Nullable
    private final String name;

    @Nullable
    private final Integer scheme;

    @Nullable
    private final String tokenApi;

    public static /* synthetic */ PlayZStreamUrl copy$default(PlayZStreamUrl playZStreamUrl, String str, String str2, Integer num, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = playZStreamUrl.name;
        }
        if ((i & 2) != 0) {
            str2 = playZStreamUrl.link;
        }
        if ((i & 4) != 0) {
            num = playZStreamUrl.scheme;
        }
        if ((i & 8) != 0) {
            str3 = playZStreamUrl.api;
        }
        if ((i & 16) != 0) {
            str4 = playZStreamUrl.tokenApi;
        }
        String str5 = str4;
        Integer num2 = num;
        return playZStreamUrl.copy(str, str2, num2, str3, str5);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLink() {
        return this.link;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getScheme() {
        return this.scheme;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getApi() {
        return this.api;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTokenApi() {
        return this.tokenApi;
    }

    @NotNull
    public final PlayZStreamUrl copy(@Nullable String name, @Nullable String link, @Nullable Integer scheme, @Nullable String api, @Nullable String tokenApi) {
        return new PlayZStreamUrl(name, link, scheme, api, tokenApi);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayZStreamUrl)) {
            return false;
        }
        PlayZStreamUrl playZStreamUrl = (PlayZStreamUrl) other;
        return Intrinsics.areEqual(this.name, playZStreamUrl.name) && Intrinsics.areEqual(this.link, playZStreamUrl.link) && Intrinsics.areEqual(this.scheme, playZStreamUrl.scheme) && Intrinsics.areEqual(this.api, playZStreamUrl.api) && Intrinsics.areEqual(this.tokenApi, playZStreamUrl.tokenApi);
    }

    public int hashCode() {
        return ((((((((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.link == null ? 0 : this.link.hashCode())) * 31) + (this.scheme == null ? 0 : this.scheme.hashCode())) * 31) + (this.api == null ? 0 : this.api.hashCode())) * 31) + (this.tokenApi != null ? this.tokenApi.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "PlayZStreamUrl(name=" + this.name + ", link=" + this.link + ", scheme=" + this.scheme + ", api=" + this.api + ", tokenApi=" + this.tokenApi + ')';
    }

    public PlayZStreamUrl(@Nullable String name, @Nullable String link, @Nullable Integer scheme, @Nullable String api, @Nullable String tokenApi) {
        this.name = name;
        this.link = link;
        this.scheme = scheme;
        this.api = api;
        this.tokenApi = tokenApi;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getLink() {
        return this.link;
    }

    @Nullable
    public final Integer getScheme() {
        return this.scheme;
    }

    @Nullable
    public final String getApi() {
        return this.api;
    }

    @Nullable
    public final String getTokenApi() {
        return this.tokenApi;
    }
}
