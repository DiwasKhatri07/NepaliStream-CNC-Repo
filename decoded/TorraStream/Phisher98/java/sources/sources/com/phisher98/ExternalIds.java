package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TorraStreamParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/TorraStream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ&\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R#\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0007z\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR%\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0007z\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/phisher98/ExternalIds;", "", "imdb_id", "", "tvdb_id", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getImdb_id", "()Ljava/lang/String;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "getTvdb_id", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/phisher98/ExternalIds;", "equals", "", "other", "hashCode", "toString", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class ExternalIds {

    @Nullable
    private final String imdb_id;

    @Nullable
    private final Integer tvdb_id;

    /* JADX WARN: Multi-variable type inference failed */
    public ExternalIds() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ExternalIds copy$default(ExternalIds externalIds, String str, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = externalIds.imdb_id;
        }
        if ((i & 2) != 0) {
            num = externalIds.tvdb_id;
        }
        return externalIds.copy(str, num);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getImdb_id() {
        return this.imdb_id;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getTvdb_id() {
        return this.tvdb_id;
    }

    @NotNull
    public final ExternalIds copy(@Nullable String imdb_id, @Nullable Integer tvdb_id) {
        return new ExternalIds(imdb_id, tvdb_id);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExternalIds)) {
            return false;
        }
        ExternalIds externalIds = (ExternalIds) other;
        return Intrinsics.areEqual(this.imdb_id, externalIds.imdb_id) && Intrinsics.areEqual(this.tvdb_id, externalIds.tvdb_id);
    }

    public int hashCode() {
        return ((this.imdb_id == null ? 0 : this.imdb_id.hashCode()) * 31) + (this.tvdb_id != null ? this.tvdb_id.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ExternalIds(imdb_id=" + this.imdb_id + ", tvdb_id=" + this.tvdb_id + ')';
    }

    public ExternalIds(@Nullable String imdb_id, @Nullable Integer tvdb_id) {
        this.imdb_id = imdb_id;
        this.tvdb_id = tvdb_id;
    }

    public /* synthetic */ ExternalIds(String str, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num);
    }

    @JsonProperty("imdb_id")
    @Nullable
    public final String getImdb_id() {
        return this.imdb_id;
    }

    @JsonProperty("tvdb_id")
    @Nullable
    public final Integer getTvdb_id() {
        return this.tvdb_id;
    }
}
