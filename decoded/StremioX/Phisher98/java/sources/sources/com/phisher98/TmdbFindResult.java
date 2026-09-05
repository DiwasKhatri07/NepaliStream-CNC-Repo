package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StremioC.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StremioX/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003JB\u0010\u0011\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0007HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/phisher98/TmdbFindResult;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "media_type", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMedia_type", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/phisher98/TmdbFindResult;", "equals", "", "other", "hashCode", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
final /* data */ class TmdbFindResult {

    @Nullable
    private final Integer id;

    @Nullable
    private final String media_type;

    /* JADX WARN: Multi-variable type inference failed */
    public TmdbFindResult() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ TmdbFindResult copy$default(TmdbFindResult tmdbFindResult, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = tmdbFindResult.id;
        }
        if ((i & 2) != 0) {
            str = tmdbFindResult.media_type;
        }
        return tmdbFindResult.copy(num, str);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMedia_type() {
        return this.media_type;
    }

    @NotNull
    public final TmdbFindResult copy(@JsonProperty("id") @Nullable Integer id, @JsonProperty("media_type") @Nullable String media_type) {
        return new TmdbFindResult(id, media_type);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TmdbFindResult)) {
            return false;
        }
        TmdbFindResult tmdbFindResult = (TmdbFindResult) other;
        return Intrinsics.areEqual(this.id, tmdbFindResult.id) && Intrinsics.areEqual(this.media_type, tmdbFindResult.media_type);
    }

    public int hashCode() {
        return ((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.media_type != null ? this.media_type.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "TmdbFindResult(id=" + this.id + ", media_type=" + this.media_type + ')';
    }

    public TmdbFindResult(@JsonProperty("id") @Nullable Integer id, @JsonProperty("media_type") @Nullable String media_type) {
        this.id = id;
        this.media_type = media_type;
    }

    public /* synthetic */ TmdbFindResult(Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str);
    }

    @Nullable
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    public final String getMedia_type() {
        return this.media_type;
    }
}
