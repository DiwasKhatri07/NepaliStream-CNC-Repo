package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JellyfinParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Jellyfin/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0016\b\u0001\u0010\u0007\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J9\u0010\u0010\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0016\b\u0003\u0010\u0007\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\bHÆ\u0001J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/phisher98/SeasonItem;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "Id", "name", "Name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Jellyfin"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class SeasonItem {

    @NotNull
    private final String id;

    @NotNull
    private final String name;

    public static /* synthetic */ SeasonItem copy$default(SeasonItem seasonItem, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = seasonItem.id;
        }
        if ((i & 2) != 0) {
            str2 = seasonItem.name;
        }
        return seasonItem.copy(str, str2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final SeasonItem copy(@JsonProperty("Id") @NotNull String id, @JsonProperty("Name") @NotNull String name) {
        return new SeasonItem(id, name);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SeasonItem)) {
            return false;
        }
        SeasonItem seasonItem = (SeasonItem) other;
        return Intrinsics.areEqual(this.id, seasonItem.id) && Intrinsics.areEqual(this.name, seasonItem.name);
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.name.hashCode();
    }

    @NotNull
    public String toString() {
        return "SeasonItem(id=" + this.id + ", name=" + this.name + ')';
    }

    public SeasonItem(@JsonProperty("Id") @NotNull String id, @JsonProperty("Name") @NotNull String name) {
        this.id = id;
        this.name = name;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }
}
