package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJB\u0010\u0015\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/phisher98/RidoContentable;", "", "imdbId", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "tmdbId", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getImdbId", "()Ljava/lang/String;", "setImdbId", "(Ljava/lang/String;)V", "getTmdbId", "()Ljava/lang/Integer;", "setTmdbId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/phisher98/RidoContentable;", "equals", "", "other", "hashCode", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class RidoContentable {

    @Nullable
    private String imdbId;

    @Nullable
    private Integer tmdbId;

    /* JADX WARN: Multi-variable type inference failed */
    public RidoContentable() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ RidoContentable copy$default(RidoContentable ridoContentable, String str, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ridoContentable.imdbId;
        }
        if ((i & 2) != 0) {
            num = ridoContentable.tmdbId;
        }
        return ridoContentable.copy(str, num);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getImdbId() {
        return this.imdbId;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getTmdbId() {
        return this.tmdbId;
    }

    @NotNull
    public final RidoContentable copy(@JsonProperty("imdbId") @Nullable String imdbId, @JsonProperty("tmdbId") @Nullable Integer tmdbId) {
        return new RidoContentable(imdbId, tmdbId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RidoContentable)) {
            return false;
        }
        RidoContentable ridoContentable = (RidoContentable) other;
        return Intrinsics.areEqual(this.imdbId, ridoContentable.imdbId) && Intrinsics.areEqual(this.tmdbId, ridoContentable.tmdbId);
    }

    public int hashCode() {
        return ((this.imdbId == null ? 0 : this.imdbId.hashCode()) * 31) + (this.tmdbId != null ? this.tmdbId.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "RidoContentable(imdbId=" + this.imdbId + ", tmdbId=" + this.tmdbId + ')';
    }

    public RidoContentable(@JsonProperty("imdbId") @Nullable String imdbId, @JsonProperty("tmdbId") @Nullable Integer tmdbId) {
        this.imdbId = imdbId;
        this.tmdbId = tmdbId;
    }

    public /* synthetic */ RidoContentable(String str, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num);
    }

    @Nullable
    public final String getImdbId() {
        return this.imdbId;
    }

    public final void setImdbId(@Nullable String str) {
        this.imdbId = str;
    }

    @Nullable
    public final Integer getTmdbId() {
        return this.tmdbId;
    }

    public final void setTmdbId(@Nullable Integer num) {
        this.tmdbId = num;
    }
}
