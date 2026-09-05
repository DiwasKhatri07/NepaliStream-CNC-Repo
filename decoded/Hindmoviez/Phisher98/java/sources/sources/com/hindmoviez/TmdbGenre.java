package com.hindmoviez;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Hindmoviez/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/hindmoviez/TmdbGenre;", "", "id", "", "name", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/hindmoviez/TmdbGenre;", "equals", "", "other", "hashCode", "toString", "Hindmoviez"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class TmdbGenre {

    @Nullable
    private final Integer id;

    @Nullable
    private final String name;

    /* JADX WARN: Multi-variable type inference failed */
    public TmdbGenre() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ TmdbGenre copy$default(TmdbGenre tmdbGenre, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = tmdbGenre.id;
        }
        if ((i & 2) != 0) {
            str = tmdbGenre.name;
        }
        return tmdbGenre.copy(num, str);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final TmdbGenre copy(@Nullable Integer id, @Nullable String name) {
        return new TmdbGenre(id, name);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TmdbGenre)) {
            return false;
        }
        TmdbGenre tmdbGenre = (TmdbGenre) other;
        return Intrinsics.areEqual(this.id, tmdbGenre.id) && Intrinsics.areEqual(this.name, tmdbGenre.name);
    }

    public int hashCode() {
        return ((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.name != null ? this.name.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "TmdbGenre(id=" + this.id + ", name=" + this.name + ')';
    }

    public TmdbGenre(@Nullable Integer id, @Nullable String name) {
        this.id = id;
        this.name = name;
    }

    public /* synthetic */ TmdbGenre(Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str);
    }

    @Nullable
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }
}
