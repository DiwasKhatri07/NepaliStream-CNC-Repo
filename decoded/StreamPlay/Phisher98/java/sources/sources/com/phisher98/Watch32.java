package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/phisher98/Watch32;", "", "type", "", "link", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getLink", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Watch32 {

    @NotNull
    private final String link;

    @NotNull
    private final String type;

    public static /* synthetic */ Watch32 copy$default(Watch32 watch32, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = watch32.type;
        }
        if ((i & 2) != 0) {
            str2 = watch32.link;
        }
        return watch32.copy(str, str2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLink() {
        return this.link;
    }

    @NotNull
    public final Watch32 copy(@NotNull String type, @NotNull String link) {
        return new Watch32(type, link);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Watch32)) {
            return false;
        }
        Watch32 watch32 = (Watch32) other;
        return Intrinsics.areEqual(this.type, watch32.type) && Intrinsics.areEqual(this.link, watch32.link);
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.link.hashCode();
    }

    @NotNull
    public String toString() {
        return "Watch32(type=" + this.type + ", link=" + this.link + ')';
    }

    public Watch32(@NotNull String type, @NotNull String link) {
        this.type = type;
        this.link = link;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final String getLink() {
        return this.link;
    }
}
