package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JellyfinParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Jellyfin/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003JW\u0010\u0014\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\nHÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/phisher98/ProviderIds;", "", "tmdb", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "Tmdb", "imdb", "Imdb", "tvdb", "Tvdb", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTmdb", "()Ljava/lang/String;", "getImdb", "getTvdb", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Jellyfin"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class ProviderIds {

    @Nullable
    private final String imdb;

    @Nullable
    private final String tmdb;

    @Nullable
    private final String tvdb;

    public ProviderIds() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ProviderIds copy$default(ProviderIds providerIds, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = providerIds.tmdb;
        }
        if ((i & 2) != 0) {
            str2 = providerIds.imdb;
        }
        if ((i & 4) != 0) {
            str3 = providerIds.tvdb;
        }
        return providerIds.copy(str, str2, str3);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTmdb() {
        return this.tmdb;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getImdb() {
        return this.imdb;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTvdb() {
        return this.tvdb;
    }

    @NotNull
    public final ProviderIds copy(@JsonProperty("Tmdb") @Nullable String tmdb, @JsonProperty("Imdb") @Nullable String imdb, @JsonProperty("Tvdb") @Nullable String tvdb) {
        return new ProviderIds(tmdb, imdb, tvdb);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProviderIds)) {
            return false;
        }
        ProviderIds providerIds = (ProviderIds) other;
        return Intrinsics.areEqual(this.tmdb, providerIds.tmdb) && Intrinsics.areEqual(this.imdb, providerIds.imdb) && Intrinsics.areEqual(this.tvdb, providerIds.tvdb);
    }

    public int hashCode() {
        return ((((this.tmdb == null ? 0 : this.tmdb.hashCode()) * 31) + (this.imdb == null ? 0 : this.imdb.hashCode())) * 31) + (this.tvdb != null ? this.tvdb.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ProviderIds(tmdb=" + this.tmdb + ", imdb=" + this.imdb + ", tvdb=" + this.tvdb + ')';
    }

    public ProviderIds(@JsonProperty("Tmdb") @Nullable String tmdb, @JsonProperty("Imdb") @Nullable String imdb, @JsonProperty("Tvdb") @Nullable String tvdb) {
        this.tmdb = tmdb;
        this.imdb = imdb;
        this.tvdb = tvdb;
    }

    public /* synthetic */ ProviderIds(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    @Nullable
    public final String getTmdb() {
        return this.tmdb;
    }

    @Nullable
    public final String getImdb() {
        return this.imdb;
    }

    @Nullable
    public final String getTvdb() {
        return this.tvdb;
    }
}
