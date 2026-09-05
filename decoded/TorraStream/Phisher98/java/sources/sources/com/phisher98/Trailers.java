package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TorraStreamParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/TorraStream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R#\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0007z\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR#\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0007z\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/phisher98/Trailers;", "", "key", "", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "getType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Trailers {

    @Nullable
    private final String key;

    @Nullable
    private final String type;

    /* JADX WARN: Illegal instructions before constructor call */
    public Trailers() {
        String str = null;
        this(str, str, 3, str);
    }

    public static /* synthetic */ Trailers copy$default(Trailers trailers, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = trailers.key;
        }
        if ((i & 2) != 0) {
            str2 = trailers.type;
        }
        return trailers.copy(str, str2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final Trailers copy(@Nullable String key, @Nullable String type) {
        return new Trailers(key, type);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Trailers)) {
            return false;
        }
        Trailers trailers = (Trailers) other;
        return Intrinsics.areEqual(this.key, trailers.key) && Intrinsics.areEqual(this.type, trailers.type);
    }

    public int hashCode() {
        return ((this.key == null ? 0 : this.key.hashCode()) * 31) + (this.type != null ? this.type.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Trailers(key=" + this.key + ", type=" + this.type + ')';
    }

    public Trailers(@Nullable String key, @Nullable String type) {
        this.key = key;
        this.type = type;
    }

    public /* synthetic */ Trailers(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    @JsonProperty("key")
    @Nullable
    public final String getKey() {
        return this.key;
    }

    @JsonProperty("type")
    @Nullable
    public final String getType() {
        return this.type;
    }
}
